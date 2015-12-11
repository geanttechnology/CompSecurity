.class public Lcom/amazon/mShop/ui/resources/DateFormat;
.super Ljava/lang/Object;
.source "DateFormat.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCalendarFromDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)Ljava/util/Calendar;
    .locals 3
    .param p0, "date"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .prologue
    .line 208
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 209
    .local v0, "calendar":Ljava/util/Calendar;
    const/4 v1, 0x1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getYear()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 210
    const/4 v1, 0x2

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getMonth()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v2, v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 211
    const/4 v1, 0x5

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getDay()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 212
    return-object v0
.end method
