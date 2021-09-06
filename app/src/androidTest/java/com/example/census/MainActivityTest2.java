package com.example.census;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        ViewInteraction extendedFloatingActionButton = onView(
                allOf(withId(R.id.create), withText("Create"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                2),
                        isDisplayed()));
        extendedFloatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.survey_title),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("literacy "), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.survey_location),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_location_id),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("zomba"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_set_start_date), withText("Set start date"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                2)));
        materialButton.perform(scrollTo(), click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btn_create_survey), withText("Create"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btn_conduct_survey), withText("Conduct"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                4)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.family_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.family),
                                        0),
                                0)));
        textInputEditText3.perform(scrollTo(), replaceText("wawa"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.num_of_people),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.people),
                                        0),
                                0)));
        textInputEditText4.perform(scrollTo(), replaceText("6"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.num_of_people_reached_sec),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.people_reached_sec),
                                        0),
                                0)));
        textInputEditText5.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.num_of_people_reached_sec), withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.people_reached_sec),
                                        0),
                                0)));
        textInputEditText6.perform(pressImeActionButton());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btn_save_family_details), withText("save data"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        materialButton5.perform(scrollTo(), click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.family_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.family),
                                        0),
                                0)));
        textInputEditText7.perform(scrollTo(), replaceText("zaza"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.num_of_people),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.people),
                                        0),
                                0)));
        textInputEditText8.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.num_of_people_reached_sec),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.people_reached_sec),
                                        0),
                                0)));
        textInputEditText9.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btn_save_family_details), withText("save data"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        materialButton6.perform(scrollTo(), click());

        pressBack();

        pressBack();

        ViewInteraction extendedFloatingActionButton2 = onView(
                allOf(withId(R.id.surveys), withText("View"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                4),
                        isDisplayed()));
        extendedFloatingActionButton2.perform(click());

        pressBack();

        ViewInteraction extendedFloatingActionButton3 = onView(
                allOf(withId(R.id.analysis), withText("Analysis"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                5),
                        isDisplayed()));
        extendedFloatingActionButton3.perform(click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
