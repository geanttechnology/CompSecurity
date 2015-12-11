.class public final Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions;
.super Ljava/lang/Object;
.source "MAPAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AuthPortalActivityUIOptions"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;,
        Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;
    }
.end annotation


# static fields
.field public static final KEY_ABOVE_LOCKSCREEN:Ljava/lang/String; = "AuthPortalActivityUIOptions.aboveLockScreen"

.field public static final KEY_AMAZON_SCREEN_MODES:Ljava/lang/String; = "AuthPortalActivityUIOptions.amazonScreenModes"

.field public static final KEY_INVERT_SPINNER:Ljava/lang/String; = "progressbar_invert_spinner"

.field public static final KEY_IS_FULLSCREEN:Ljava/lang/String; = "AuthPortalActivityUIOptions.fullscreen"

.field public static final KEY_PROGRESSBAR_BACKGROUND_RESOURCE:Ljava/lang/String; = "progressbar_background_resource"

.field public static final KEY_PROGRESSBAR_FADE:Ljava/lang/String; = "progressbar_fade"

.field public static final KEY_PROGRESSBAR_POSITION:Ljava/lang/String; = "progressbar_position"

.field public static final KEY_PROGRESSBAR_PRIMARY_COLOR:Ljava/lang/String; = "progressbar_primary_color"

.field public static final KEY_PROGRESSBAR_RESOURCE:Ljava/lang/String; = "progressbar_resource"

.field public static final KEY_PROGRESSBAR_SECONDARY_COLOR:Ljava/lang/String; = "progressbar_secondary_color"

.field public static final KEY_PROGRESSBAR_STATE:Ljava/lang/String; = "progressbar_state"

.field public static final KEY_PROGRESSBAR_STRETCH:Ljava/lang/String; = "progressbar_stretch"

.field public static final KEY_REQUESTED_ORIENTATION:Ljava/lang/String; = "AuthPortalActivityUIOptions.requestedOrientation"

.field public static final KEY_SPLASH_SCREEN_RESOURCE:Ljava/lang/String; = "splashscreen_resource"

.field public static final KEY_SPLASH_SCREEN_SCALE_TYPE:Ljava/lang/String; = "splashscreen_scale_type"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 561
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 695
    return-void
.end method
