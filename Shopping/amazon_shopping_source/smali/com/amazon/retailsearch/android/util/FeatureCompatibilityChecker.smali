.class public Lcom/amazon/retailsearch/android/util/FeatureCompatibilityChecker;
.super Ljava/lang/Object;
.source "FeatureCompatibilityChecker.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static useCompatFragment(Landroid/content/Context;)Ljava/lang/Boolean;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    const/4 v0, 0x0

    .line 32
    .local v0, "useCompat":Z
    instance-of v1, p0, Landroid/support/v4/app/FragmentActivity;

    if-eqz v1, :cond_1

    .line 34
    const/4 v0, 0x1

    .line 40
    :cond_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    :goto_0
    return-object v1

    .line 36
    :cond_1
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-ge v1, v2, :cond_0

    .line 38
    const/4 v1, 0x0

    goto :goto_0
.end method
