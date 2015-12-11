.class Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->b:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->a:Landroid/view/View;

    const v1, 0x7f0c00ad

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 91
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->a:Landroid/view/View;

    const v2, 0x7f0c00ae

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 92
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->b:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)I

    move-result v3

    invoke-static {v0, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;I)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->b:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 120
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;->b:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->b(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)Landroid/app/Activity;

    move-result-object v0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 121
    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 122
    return-void

    .line 96
    :pswitch_1
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgm;->a(Lft;)V

    goto :goto_0

    .line 99
    :pswitch_2
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgd;->a(Lft;)V

    goto :goto_0

    .line 102
    :pswitch_3
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgg;->a(Lft;)V

    goto :goto_0

    .line 105
    :pswitch_4
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lfu;->a(Lft;)V

    goto :goto_0

    .line 108
    :pswitch_5
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lfw;->a(Lft;)V

    goto :goto_0

    .line 111
    :pswitch_6
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgk;->a(Lft;)V

    goto :goto_0

    .line 114
    :pswitch_7
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgq;->a(Lft;)V

    goto :goto_0

    .line 117
    :pswitch_8
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lga;->a(Lft;)V

    goto :goto_0

    .line 94
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_8
        :pswitch_7
    .end packed-switch
.end method
