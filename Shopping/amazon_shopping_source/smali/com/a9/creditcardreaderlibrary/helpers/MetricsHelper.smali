.class public Lcom/a9/creditcardreaderlibrary/helpers/MetricsHelper;
.super Ljava/lang/Object;
.source "MetricsHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getServiceName(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    const-string/jumbo v0, "SERVICE_NAME"

    invoke-static {p0, v0}, Lcom/a9/creditcardreaderlibrary/utils/PreferenceUtil;->getPreference(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
