package com.example.android.recyclerviewespresso;


import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;


public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickItem() {

//        onView(allOf(withId(R.id.button1), isDescendantOfA(withId(R.id.linear_layout)))).perform(click());
//
//        onView(allOf(withId(R.id.button1), withParent(withId(R.id.linear_layout)))).perform(click());
//
        Matcher<View> viewMatcher = allOf(withId(R.id.button1), withParent(withId(R.id.linear_layout))); //idem above
        ViewAction actionPerform = click();
//        onView(viewMatcher).perform(actionPerform);
//
//        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
//
//        //To work properly this method need device to have turned off animation scale
//        //see : https://guides.codepath.com/android/UI-Testing-with-Espresso
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
//
//        viewMatcher = withRecyclerView(R.id.recycler_view).atPosition(1); //Equivalent above
//        actionPerform = click();
//        onView(viewMatcher).perform(actionPerform);
//

        onView(withRecyclerView(R.id.recycler_view).atPositionOnView(1, R.id.text2)).perform(click());

        onView(allOf(withId(R.id.text2), withRecyclerView(R.id.recycler_view).atPosition(1))).perform(click());

        onView(allOf(withId(R.id.text1), withText("toto"), isDescendantOfA(withId(R.id.item_linear_layout)))).perform(click());

        onView(allOf(withId(R.id.item_linear_layout), withChild(allOf(withId(R.id.text1), withText("toto"))))).perform(click());

       // onView(allOf(withId(R.id.text2), isDescendantOfA(allOf(withId(R.id.item_linear_layout), )))).perform(click());


        onView(allOf(withId(R.id.text2), withParent(allOf(withId(R.id.item_linear_layout), withChild(allOf(withId(R.id.text1), withText("toto"))))))).perform(click());

        viewMatcher = withRecyclerView(R.id.recycler_view).atPosition(1); //select parent view
        Matcher<View> childView = allOf(withId(R.id.text1), isDescendantOfA(withId(R.id.item_linear_layout))); //select child view
        //Matcher<View> childViewMatcher = hasDescendant(childView); //select childview from parent children views.
        Matcher<View> childViewMatcher = allOf(childView, viewMatcher); //select childview from parent children views.
        actionPerform = click();
        onView(childViewMatcher).perform(actionPerform);
//        ViewAssertion actionCheck = matches(childViewMatcher);
//        onView(viewMatcher).check()

        viewMatcher = withRecyclerView(R.id.recycler_view).atPositionOnView(1, R.id.button1); //Does not work
        actionPerform = click();
        onView(viewMatcher).perform(actionPerform);

        viewMatcher = withRecyclerView(R.id.recycler_view).atPositionOnView(1, R.id.button2);
        actionPerform = click();
        onView(viewMatcher).perform(actionPerform);


        //     onView(withId(R.id.text)).check(matches(not(isDisplayed())));

//        onView(withId(R.id.linear_layout)).check(isDisplayed());

//        onData(withId(R.id.linear_layout))
//                .onChildView(withId(R.id.button1))
//                .perform(click());

//        onData(withValue(1))
//                .inAdapterView(withId(R.id.list))
//                .perform(click());
//
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
//
//        onView(withId(R.id.text)).check(matches(withText("1"))).check(matches(isDisplayed()));

//        onView(allOf(withId(R.id.include_one), isDescendantOfA(withId(R.id.button1)))).perform(click());
//
//        onView(allOf(withId(R.id.button1), hasParent(withId(R.id.include_one)))).perform(click());


    }

//
//    public static Matcher<Object> withValue(final int value) {
//
//        return new BoundedMatcher<Object, MainActivity.Item>(MainActivity.Item.class) {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("has value " + value);
//            }
//            @Override
//            public boolean matchesSafely(MainActivity.Item item) {
//                return item.toString().equals(String.valueOf(value));
//            }
//        };
//    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}