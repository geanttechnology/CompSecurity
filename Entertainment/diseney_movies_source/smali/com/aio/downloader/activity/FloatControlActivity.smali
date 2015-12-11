.class public Lcom/aio/downloader/activity/FloatControlActivity;
.super Landroid/app/Activity;
.source "FloatControlActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private cb_float:Landroid/widget/CheckBox;

.field private intent_float:Landroid/content/Intent;

.field private userInfo:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/Intent;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity;->userInfo:Landroid/content/SharedPreferences;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 63
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 71
    :goto_0
    return-void

    .line 65
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatControlActivity;->finish()V

    goto :goto_0

    .line 63
    :pswitch_data_0
    .packed-switch 0x7f0701d7
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 24
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    const v2, 0x7f030043

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FloatControlActivity;->setContentView(I)V

    .line 26
    const v2, 0x7f0701d7

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FloatControlActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 27
    const v2, 0x7f0701d8

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FloatControlActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iput-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->cb_float:Landroid/widget/CheckBox;

    .line 28
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatControlActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/aio/downloader/floatwindow/FloatWindowService;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;

    .line 29
    const-string v2, "floatctri"

    invoke-virtual {p0, v2, v5}, Lcom/aio/downloader/activity/FloatControlActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->userInfo:Landroid/content/SharedPreferences;

    .line 31
    const-string v2, "floatctri"

    invoke-virtual {p0, v2, v5}, Lcom/aio/downloader/activity/FloatControlActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 33
    .local v1, "userInfo_float":Landroid/content/SharedPreferences;
    const-string v2, "fctri"

    invoke-interface {v1, v2, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 34
    .local v0, "showfloat":Z
    if-eqz v0, :cond_0

    .line 35
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->cb_float:Landroid/widget/CheckBox;

    invoke-virtual {v2, v6}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 36
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FloatControlActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 44
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->cb_float:Landroid/widget/CheckBox;

    new-instance v3, Lcom/aio/downloader/activity/FloatControlActivity$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/FloatControlActivity$1;-><init>(Lcom/aio/downloader/activity/FloatControlActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 58
    return-void

    .line 38
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->cb_float:Landroid/widget/CheckBox;

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 39
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/FloatControlActivity;->stopService(Landroid/content/Intent;)Z

    goto :goto_0
.end method
