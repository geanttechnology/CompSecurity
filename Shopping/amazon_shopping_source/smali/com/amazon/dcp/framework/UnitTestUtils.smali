.class public final Lcom/amazon/dcp/framework/UnitTestUtils;
.super Ljava/lang/Object;
.source "UnitTestUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    return-void
.end method

.method public static isRunningInUnitTest()Z
    .locals 2

    .prologue
    .line 15
    :try_start_0
    const-string/jumbo v1, "android.test.mock.MockContext"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 16
    const/4 v1, 0x1

    .line 20
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    return v1

    .line 18
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_0
    move-exception v0

    .line 20
    .restart local v0    # "e":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method
