.class public final Lcom/amazon/identity/auth/device/utils/UnitTestUtils;
.super Ljava/lang/Object;
.source "UnitTestUtils.java"


# static fields
.field private static final IS_RUNNING_IN_UNIT_TEST:Z

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->TAG:Ljava/lang/String;

    .line 10
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->generateIsRunningInUnitTest()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->IS_RUNNING_IN_UNIT_TEST:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    return-void
.end method

.method private static generateIsRunningInUnitTest()Z
    .locals 2

    .prologue
    .line 26
    :try_start_0
    const-string/jumbo v0, "android.test.mock.MockContext"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 27
    const-string/jumbo v0, "com.amazon.identity.auth.unittest.IsRunningInUnitTest"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 28
    sget-object v0, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Is running in unit test!"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    const/4 v0, 0x1

    .line 33
    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isRunningInUnitTest()Z
    .locals 1

    .prologue
    .line 19
    sget-boolean v0, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->IS_RUNNING_IN_UNIT_TEST:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPInit;->isRunningInFunctionalTest()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
