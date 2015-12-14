.class public Lcom/livemixtapes/utils/Utility;
.super Ljava/lang/Object;
.source "Utility.java"


# static fields
.field private static final apiDateFormat:Ljava/text/SimpleDateFormat;

.field private static final shortDateFormat:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 15
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'hh:mm:ss\'Z\'"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/livemixtapes/utils/Utility;->apiDateFormat:Ljava/text/SimpleDateFormat;

    .line 16
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "M/d/yy"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/livemixtapes/utils/Utility;->shortDateFormat:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static dpToPixel(Landroid/content/Context;F)F
    .locals 2
    .param p0, "act"    # Landroid/content/Context;
    .param p1, "dpValue"    # F

    .prologue
    .line 30
    const/4 v0, 0x1

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v0, p1, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

.method public static formatDateShort(Ljava/util/Date;)Ljava/lang/String;
    .locals 1
    .param p0, "dt"    # Ljava/util/Date;

    .prologue
    .line 43
    sget-object v0, Lcom/livemixtapes/utils/Utility;->shortDateFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v0, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static hideKeyboard(Landroid/app/Activity;)V
    .locals 4
    .param p0, "context"    # Landroid/app/Activity;

    .prologue
    .line 19
    invoke-virtual {p0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    .line 20
    .local v1, "view":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 21
    const-string v2, "input_method"

    invoke-virtual {p0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 22
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 24
    .end local v0    # "imm":Landroid/view/inputmethod/InputMethodManager;
    :cond_0
    const-string v2, "Utility"

    const-string v3, "Hide keyboard..."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    return-void
.end method

.method public static parseApiDate(Ljava/lang/String;)Ljava/util/Date;
    .locals 2
    .param p0, "dateString"    # Ljava/lang/String;

    .prologue
    .line 35
    :try_start_0
    sget-object v1, Lcom/livemixtapes/utils/Utility;->apiDateFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v1, p0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 38
    :goto_0
    return-object v1

    .line 36
    :catch_0
    move-exception v0

    .line 37
    .local v0, "ex":Ljava/text/ParseException;
    invoke-virtual {v0}, Ljava/text/ParseException;->printStackTrace()V

    .line 38
    const/4 v1, 0x0

    goto :goto_0
.end method
