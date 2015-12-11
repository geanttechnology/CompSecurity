.class Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;
.super Ljava/lang/Object;
.source "DebugSettingsActivityForAds.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

.field final synthetic val$channelEditText:Landroid/widget/EditText;

.field final synthetic val$logOption:Landroid/widget/CheckBox;

.field final synthetic val$pref:Landroid/content/SharedPreferences;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;Landroid/content/SharedPreferences;Landroid/widget/CheckBox;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->this$0:Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

    iput-object p2, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$pref:Landroid/content/SharedPreferences;

    iput-object p3, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$logOption:Landroid/widget/CheckBox;

    iput-object p4, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$channelEditText:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 101
    iget-object v7, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$pref:Landroid/content/SharedPreferences;

    invoke-interface {v7}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 102
    .local v5, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v7, "Logging"

    iget-object v8, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$logOption:Landroid/widget/CheckBox;

    invoke-virtual {v8}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v8

    invoke-interface {v5, v7, v8}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 103
    iget-object v7, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->val$channelEditText:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 104
    .local v3, "channel":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 105
    const-string/jumbo v3, "100"

    .line 107
    :cond_0
    const-string/jumbo v7, "Channel"

    invoke-interface {v5, v7, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 109
    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$000()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    .line 110
    .local v2, "adsTypeSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 111
    .local v4, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 112
    .local v0, "adsId":Ljava/lang/String;
    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 113
    .local v1, "adsType":Ljava/lang/String;
    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$100()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v5, v7, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 116
    .end local v0    # "adsId":Ljava/lang/String;
    .end local v1    # "adsType":Ljava/lang/String;
    .end local v4    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 117
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 118
    iget-object v7, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;->this$0:Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

    invoke-virtual {v7}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->finish()V

    .line 119
    return-void
.end method
