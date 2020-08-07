package org.iiui.projectversion1;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Roomreservation implements BaseColumns {

        public static final String TAB_USER = "User_Info";
        public static final String U_COL_1 = "U_ID";
        public static final String U_COL_2 = "U_NAME";
        public static final String U_COL_3 ="U_CONTACT";
        public static final String U_COL_4 ="U_EMAIL";
        public static final String U_COL_5 ="U_PASS";

        public static final String TAB_ROOM = "Room_Info";
        public static final String R_COL_1 = "R_ID";
        public static final String R_COL_2 = "R_NUMBER";
        public static final String R_COL_3 ="R_TYPE";
        public static final String R_COL_4 ="R_COST";
        public static final String R_COL_5 ="R_OCCUPIED";

        public static final String TAB_ROOM_DATES = "Room_Dates_Info";
        public static final String RD_COL_1 = "RD_ID";
        public static final String RD_COL_2 = "RD_NUMBER";
        public static final String RD_COL_3 = "RD_CHECKIN";
        public static final String RD_COL_4 ="RD_CHECKOUT";

        public static final String TAB_BOOKING = "Booking_Info";
        public static final String B_COL_1 = "B_ID";
        public static final String B_COL_2 = "B_NAME";
        public static final String B_COL_3 = "B_CNIC";
        public static final String B_COL_4 = "B_EMAIL";
        public static final String B_COL_5 = "B_CHECKIN";
        public static final String B_COL_6 = "B_CHECKOUT";
        public static final String B_COL_7 = "B_ROOMNO";
        public static final String B_COL_8 = "B_ROOMTYPE";


    }
}