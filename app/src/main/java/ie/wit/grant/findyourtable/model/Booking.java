package ie.wit.grant.findyourtable.model;

/**
 * Created by grantpower on 13/12/2017.
 */

public class Booking {

        public int bookingId;
        private String bookingName;
        private String bookingDate;

        public int getbookingId() {
            return bookingId;
        }

        public void setbookingId(int bookingId) {
            this.bookingId = bookingId;
        }

        public String getbookingName() {return bookingName;}

        public void setbookingName(String bookingName) { this.bookingName = bookingName; }

        public String getbookingDate() {return bookingDate;}

        public void setbookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    }


