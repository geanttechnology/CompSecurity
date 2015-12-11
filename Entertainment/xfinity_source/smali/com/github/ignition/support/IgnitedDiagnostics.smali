.class public Lcom/github/ignition/support/IgnitedDiagnostics;
.super Ljava/lang/Object;
.source "IgnitedDiagnostics.java"


# static fields
.field public static final ANDROID_API_LEVEL:I

.field public static final SUPPORTS_CUPCAKE:Z

.field public static final SUPPORTS_DONUT:Z

.field public static final SUPPORTS_ECLAIR:Z

.field public static final SUPPORTS_FROYO:Z

.field public static final SUPPORTS_GINGERBREAD:Z

.field public static final SUPPORTS_HONEYCOMB:Z

.field public static final SUPPORTS_ICS:Z

.field private static test:Z


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 46
    sput-boolean v4, Lcom/github/ignition/support/IgnitedDiagnostics;->test:Z

    .line 50
    const/4 v0, -0x1

    .line 52
    .local v0, "apiLevel":I
    :try_start_0
    const-class v2, Landroid/os/Build$VERSION;

    const-string v5, "SDK_INT"

    invoke-virtual {v2, v5}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 56
    :goto_0
    sput v0, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    .line 57
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/16 v5, 0xe

    if-lt v2, v5, :cond_0

    move v2, v3

    :goto_1
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_ICS:Z

    .line 58
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/16 v5, 0xb

    if-lt v2, v5, :cond_1

    move v2, v3

    :goto_2
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_HONEYCOMB:Z

    .line 59
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/16 v5, 0x9

    if-lt v2, v5, :cond_2

    move v2, v3

    :goto_3
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_GINGERBREAD:Z

    .line 60
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/16 v5, 0x8

    if-lt v2, v5, :cond_3

    move v2, v3

    :goto_4
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_FROYO:Z

    .line 61
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/4 v5, 0x7

    if-lt v2, v5, :cond_4

    move v2, v3

    :goto_5
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_ECLAIR:Z

    .line 62
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/4 v5, 0x4

    if-lt v2, v5, :cond_5

    move v2, v3

    :goto_6
    sput-boolean v2, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_DONUT:Z

    .line 63
    sget v2, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/4 v5, 0x3

    if-lt v2, v5, :cond_6

    :goto_7
    sput-boolean v3, Lcom/github/ignition/support/IgnitedDiagnostics;->SUPPORTS_CUPCAKE:Z

    .line 64
    return-void

    .line 53
    :catch_0
    move-exception v1

    .line 54
    .local v1, "e":Ljava/lang/Exception;
    sget-object v2, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    move v2, v4

    .line 57
    goto :goto_1

    :cond_1
    move v2, v4

    .line 58
    goto :goto_2

    :cond_2
    move v2, v4

    .line 59
    goto :goto_3

    :cond_3
    move v2, v4

    .line 60
    goto :goto_4

    :cond_4
    move v2, v4

    .line 61
    goto :goto_5

    :cond_5
    move v2, v4

    .line 62
    goto :goto_6

    :cond_6
    move v3, v4

    .line 63
    goto :goto_7
.end method
