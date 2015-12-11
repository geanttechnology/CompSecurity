.class Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;
.super Ljava/lang/Object;
.source "PlayerPrefsHeaderAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

.field final synthetic val$header:Landroid/preference/PreferenceActivity$Header;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;Landroid/preference/PreferenceActivity$Header;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$header:Landroid/preference/PreferenceActivity$Header;

    iput p3, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 113
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 114
    .local v0, "context":Landroid/content/Context;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$header:Landroid/preference/PreferenceActivity$Header;

    iget-wide v6, v5, Landroid/preference/PreferenceActivity$Header;->id:J

    sget v5, Lcom/xfinity/playerlib/R$id;->settings_sign_out:I

    int-to-long v8, v5

    cmp-long v5, v6, v8

    if-nez v5, :cond_0

    .line 115
    new-instance v2, Landroid/content/Intent;

    const-class v5, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-direct {v2, v0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 116
    .local v2, "intent":Landroid/content/Intent;
    const-string v5, "android.intent.action.VIEW"

    invoke-virtual {v2, v5}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 117
    invoke-virtual {v0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 135
    .end local v2    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 118
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$header:Landroid/preference/PreferenceActivity$Header;

    iget-wide v6, v5, Landroid/preference/PreferenceActivity$Header;->id:J

    sget v5, Lcom/xfinity/playerlib/R$id;->settings_rate:I

    int-to-long v8, v5

    cmp-long v5, v6, v8

    if-nez v5, :cond_2

    .line 119
    new-instance v2, Landroid/content/Intent;

    const-class v5, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-direct {v2, v0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 120
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v5, "android.intent.action.VIEW"

    invoke-virtual {v2, v5}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 122
    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->access$100(Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindleOrFromAmazonStore()Z

    move-result v5

    if-eqz v5, :cond_1

    sget v5, Lcom/xfinity/playerlib/R$string;->url_amazon_market_app_url:I

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    :goto_1
    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 123
    .local v3, "marketUrl":Ljava/lang/StringBuilder;
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 125
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 126
    .local v1, "extras":Landroid/os/Bundle;
    const-string v5, "title"

    sget v6, Lcom/xfinity/playerlib/R$string;->settings_rate_title:I

    invoke-virtual {v0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v5, "url"

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    invoke-virtual {v2, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 130
    invoke-virtual {v0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 122
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v3    # "marketUrl":Ljava/lang/StringBuilder;
    :cond_1
    sget v5, Lcom/xfinity/playerlib/R$string;->url_android_market_app_url:I

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 132
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    check-cast v4, Landroid/widget/ListView;

    .line 133
    .local v4, "parent":Landroid/widget/ListView;
    iget v5, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$position:I

    iget-object v6, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;->val$header:Landroid/preference/PreferenceActivity$Header;

    iget-wide v6, v6, Landroid/preference/PreferenceActivity$Header;->id:J

    invoke-virtual {v4, p1, v5, v6, v7}, Landroid/widget/ListView;->performItemClick(Landroid/view/View;IJ)Z

    goto :goto_0
.end method
