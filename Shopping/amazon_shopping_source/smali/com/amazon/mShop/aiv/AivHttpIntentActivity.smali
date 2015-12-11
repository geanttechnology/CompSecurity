.class public Lcom/amazon/mShop/aiv/AivHttpIntentActivity;
.super Landroid/app/Activity;
.source "AivHttpIntentActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;,
        Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    }
.end annotation


# static fields
.field private static final ASIN_POSITION:I = 0x3

.field private static final COMMAND_POSITION:I = 0x5

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 28
    return-void
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 97
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 98
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    .line 100
    .local v0, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0, v0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->performCommandForSegments(Landroid/app/Activity;Ljava/util/List;)V

    .line 101
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->finish()V

    .line 102
    return-void
.end method
