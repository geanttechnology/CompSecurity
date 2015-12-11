.class Lnu$5;
.super Landroid/os/Handler;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnu;
.end annotation


# instance fields
.field final synthetic a:Lnu;


# direct methods
.method constructor <init>(Lnu;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lnu$5;->a:Lnu;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4

    .prologue
    .line 234
    const/4 v1, 0x0

    .line 235
    iget v2, p1, Landroid/os/Message;->what:I

    .line 236
    iget-object v0, p0, Lnu$5;->a:Lnu;

    invoke-static {v0}, Lnu;->b(Lnu;)Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 237
    iget-object v0, p0, Lnu$5;->a:Lnu;

    invoke-static {v0}, Lnu;->b(Lnu;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 238
    const v3, 0x7f0c0033

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 239
    instance-of v3, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v3, :cond_1

    .line 240
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 243
    :goto_0
    packed-switch v2, :pswitch_data_0

    .line 255
    :cond_0
    :goto_1
    return-void

    .line 245
    :pswitch_0
    if-eqz v0, :cond_0

    .line 246
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d()V

    goto :goto_1

    .line 250
    :pswitch_1
    if-eqz v0, :cond_0

    .line 251
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->c()V

    goto :goto_1

    :cond_1
    move-object v0, v1

    goto :goto_0

    .line 243
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
