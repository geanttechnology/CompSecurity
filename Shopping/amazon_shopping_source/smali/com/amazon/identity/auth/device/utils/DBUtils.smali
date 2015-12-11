.class public final Lcom/amazon/identity/auth/device/utils/DBUtils;
.super Ljava/lang/Object;
.source "DBUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    return-void
.end method

.method public static getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 15
    .local v0, "columnIndex":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 17
    const/4 v1, 0x0

    .line 20
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method
