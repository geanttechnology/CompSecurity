.class public Lcom/amazon/mShop/AmazonChooserActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "AmazonChooserActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;,
        Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 371
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/AmazonChooserActivity;Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonChooserActivity;
    .param p1, "x1"    # Landroid/content/pm/ResolveInfo;
    .param p2, "x2"    # Landroid/content/Intent;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/AmazonChooserActivity;->startResolvedActivity(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/lang/String;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonChooserActivity;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # I

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/AmazonChooserActivity;->setSeletedResult(Ljava/lang/String;I)V

    return-void
.end method

.method public static getIntentToStart(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 149
    new-instance v0, Landroid/content/Intent;

    const-class v3, Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-direct {v0, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 150
    .local v0, "newIntent":Landroid/content/Intent;
    move-object v1, p1

    .line 151
    .local v1, "targetIntent":Landroid/content/Intent;
    const-string/jumbo v3, "android.intent.action.CHOOSER"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 152
    invoke-static {p1}, Lcom/amazon/mShop/AmazonChooserActivity;->getTargetIntent(Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    .line 154
    :cond_0
    const-string/jumbo v3, "android.intent.extra.INTENT"

    invoke-virtual {v0, v3, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 155
    invoke-static {p1}, Lcom/amazon/mShop/AmazonChooserActivity;->getTitleFromIntent(Landroid/content/Intent;)Ljava/lang/CharSequence;

    move-result-object v2

    .line 156
    .local v2, "title":Ljava/lang/CharSequence;
    if-eqz v2, :cond_1

    .line 157
    const-string/jumbo v3, "android.intent.extra.TITLE"

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 161
    :goto_0
    const-class v3, Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-virtual {v0, p0, v3}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 162
    return-object v0

    .line 159
    :cond_1
    const-string/jumbo v3, "android.intent.extra.TITLE"

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->amazon_chooser_activity_choose_appliaction:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method private static getTargetIntent(Landroid/content/Intent;)Landroid/content/Intent;
    .locals 5
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 166
    const-string/jumbo v2, "android.intent.extra.INTENT"

    invoke-virtual {p0, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    .line 167
    .local v1, "targetParcelable":Landroid/os/Parcelable;
    instance-of v2, v1, Landroid/content/Intent;

    if-nez v2, :cond_0

    .line 168
    const-string/jumbo v2, "AmazonChooserActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Target is not an intent: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    const/4 v0, 0x0

    .line 172
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    .line 171
    check-cast v0, Landroid/content/Intent;

    .line 172
    .local v0, "target":Landroid/content/Intent;
    goto :goto_0
.end method

.method private static getTitleFromIntent(Landroid/content/Intent;)Ljava/lang/CharSequence;
    .locals 1
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 176
    const-string/jumbo v0, "android.intent.extra.TITLE"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method private processTargetIntent(Landroid/content/Intent;Ljava/lang/CharSequence;)V
    .locals 21
    .param p1, "targetIntent"    # Landroid/content/Intent;
    .param p2, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 65
    invoke-static {}, Lcom/amazon/mShop/share/WechatSDKManager;->hasPendingTransaction()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 68
    invoke-static {}, Lcom/amazon/mShop/share/WechatSDKManager;->getWechatLauncherInfo()Lcom/amazon/mShop/share/SharableAppInfo;

    move-result-object v20

    .line 69
    .local v20, "wechatLauncherInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-static {v0, v1}, Lcom/amazon/mShop/share/SharableAppInfoManager;->replaceRefMarker(Landroid/content/Intent;Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 70
    invoke-static/range {p0 .. p1}, Lcom/amazon/mShop/share/WechatSDKManager;->sendResponse(Landroid/content/Context;Landroid/content/Intent;)Z

    move-result v19

    .line 71
    .local v19, "shared":Z
    if-eqz v19, :cond_0

    .line 72
    invoke-static/range {v20 .. v20}, Lcom/amazon/mShop/share/SharableAppInfoManager;->logClickRefMarker(Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 74
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/share/WechatSDKManager;->clearPendingTransaction()V

    .line 78
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->exitApp()V

    .line 135
    .end local v19    # "shared":Z
    .end local v20    # "wechatLauncherInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    :goto_0
    return-void

    .line 82
    :cond_1
    new-instance v17, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 83
    .local v17, "dialogBuilder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v8

    .line 84
    .local v8, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    const/4 v2, 0x0

    .line 85
    .local v2, "listAdapter":Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/high16 v5, 0x10000

    move-object/from16 v0, p1

    invoke-virtual {v3, v0, v5}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v4

    .line 87
    .local v4, "infoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v4, :cond_2

    .line 88
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    const/4 v5, 0x1

    if-le v3, v5, :cond_5

    .line 91
    const-string/jumbo v3, "zh_CN"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string/jumbo v3, "text/plain"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 94
    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/share/SharableAppInfoManager;->collectAppInfo(Landroid/app/Activity;)Ljava/util/List;

    move-result-object v6

    .line 95
    .local v6, "appList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/share/SharableAppInfo;>;"
    invoke-static {}, Lcom/amazon/mShop/share/SharableAppInfoManager;->getNumberOfInterestedApps()I

    move-result v7

    .line 96
    .local v7, "foldPosition":I
    new-instance v2, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;

    .end local v2    # "listAdapter":Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    move-object/from16 v3, p0

    move-object/from16 v5, p1

    invoke-direct/range {v2 .. v8}, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;-><init>(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/util/List;Landroid/content/Intent;Ljava/util/List;ILcom/amazon/mShop/AmazonAlertDialog;)V

    .line 124
    .end local v6    # "appList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/share/SharableAppInfo;>;"
    .end local v7    # "foldPosition":I
    .restart local v2    # "listAdapter":Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    :cond_2
    :goto_1
    if-eqz p2, :cond_8

    invoke-virtual/range {p2 .. p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 125
    .local v11, "dialogTitle":Ljava/lang/String;
    :goto_2
    const/4 v14, -0x1

    move-object/from16 v9, p0

    move-object v10, v8

    move-object v12, v2

    move-object v13, v2

    invoke-static/range {v9 .. v14}, Lcom/amazon/mShop/AmazonAlertDialog;->customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V

    .line 126
    if-nez v2, :cond_3

    .line 129
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->amazon_chooser_activity_no_application:I

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 132
    :cond_3
    move-object/from16 v0, p0

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 133
    move-object/from16 v0, p0

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 134
    invoke-virtual {v8}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto :goto_0

    .line 98
    .end local v11    # "dialogTitle":Ljava/lang/String;
    :cond_4
    new-instance v16, Landroid/content/pm/ResolveInfo$DisplayNameComparator;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    move-object/from16 v0, v16

    invoke-direct {v0, v3}, Landroid/content/pm/ResolveInfo$DisplayNameComparator;-><init>(Landroid/content/pm/PackageManager;)V

    .line 99
    .local v16, "comparator":Landroid/content/pm/ResolveInfo$DisplayNameComparator;
    move-object/from16 v0, v16

    invoke-static {v4, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 100
    new-instance v2, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    .end local v2    # "listAdapter":Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v4, v1, v8}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;-><init>(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/util/List;Landroid/content/Intent;Lcom/amazon/mShop/AmazonAlertDialog;)V

    .line 101
    .restart local v2    # "listAdapter":Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    goto :goto_1

    .line 102
    .end local v16    # "comparator":Landroid/content/pm/ResolveInfo$DisplayNameComparator;
    :cond_5
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_2

    .line 105
    const-string/jumbo v3, "zh_CN"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 107
    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/share/SharableAppInfoManager;->collectAppInfo(Landroid/app/Activity;)Ljava/util/List;

    move-result-object v6

    .line 108
    .restart local v6    # "appList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/share/SharableAppInfo;>;"
    if-eqz v6, :cond_7

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_7

    .line 109
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v18

    .local v18, "i$":Ljava/util/Iterator;
    :cond_6
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/amazon/mShop/share/SharableAppInfo;

    .line 110
    .local v15, "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    invoke-virtual {v15}, Lcom/amazon/mShop/share/SharableAppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    const/4 v3, 0x0

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    iget-object v3, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v3, v3, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 111
    move-object/from16 v0, p1

    invoke-static {v0, v15}, Lcom/amazon/mShop/share/SharableAppInfoManager;->replaceRefMarker(Landroid/content/Intent;Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 112
    invoke-static {v15}, Lcom/amazon/mShop/share/SharableAppInfoManager;->logClickRefMarker(Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 118
    .end local v6    # "appList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/share/SharableAppInfo;>;"
    .end local v15    # "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    .end local v18    # "i$":Ljava/util/Iterator;
    :cond_7
    const/4 v3, 0x0

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v3, v1}, Lcom/amazon/mShop/AmazonChooserActivity;->startResolvedActivity(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V

    .line 119
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/AmazonChooserActivity;->finishIfNotFinishing()V

    goto/16 :goto_0

    .line 124
    :cond_8
    const/4 v11, 0x0

    goto/16 :goto_2
.end method

.method private setSeletedResult(Ljava/lang/String;I)V
    .locals 3
    .param p1, "selectedServiceName"    # Ljava/lang/String;
    .param p2, "resultCode"    # I

    .prologue
    .line 180
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 181
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 182
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 183
    .local v0, "bundle":Landroid/os/Bundle;
    const-string/jumbo v2, "SelectedResult"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 186
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_0
    invoke-virtual {p0, p2, v1}, Lcom/amazon/mShop/AmazonChooserActivity;->setResult(ILandroid/content/Intent;)V

    .line 187
    return-void
.end method

.method private startResolvedActivity(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V
    .locals 9
    .param p1, "inf"    # Landroid/content/pm/ResolveInfo;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 191
    const-string/jumbo v7, "com.amazon.mShop.android.extra_html"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string/jumbo v7, "com.amazon.mShop.android.extra_html"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 192
    new-instance v2, Landroid/content/Intent;

    const-string/jumbo v7, "android.intent.action.SEND"

    invoke-direct {v2, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 193
    .local v2, "htmlIntent":Landroid/content/Intent;
    const-string/jumbo v7, "text/html"

    invoke-virtual {v2, v7}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 194
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    const/high16 v8, 0x10000

    invoke-virtual {v7, v2, v8}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 196
    .local v0, "htmlActivities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 197
    .local v1, "htmlInf":Landroid/content/pm/ResolveInfo;
    iget-object v7, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v7, v7, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object v8, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v8, v8, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 199
    const-string/jumbo v7, "com.amazon.mShop.android.extra_html"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v3

    check-cast v3, Landroid/text/Spannable;

    .line 200
    .local v3, "htmlText":Landroid/text/Spannable;
    const-string/jumbo v7, "android.intent.extra.TEXT"

    invoke-virtual {p2, v7, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    goto :goto_0

    .line 205
    .end local v0    # "htmlActivities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .end local v1    # "htmlInf":Landroid/content/pm/ResolveInfo;
    .end local v2    # "htmlIntent":Landroid/content/Intent;
    .end local v3    # "htmlText":Landroid/text/Spannable;
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v7, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v7, v7, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v5, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 206
    .local v5, "packName":Ljava/lang/String;
    new-instance v7, Landroid/content/ComponentName;

    iget-object v8, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v8, v8, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-direct {v7, v5, v8}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2, v7}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 207
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 212
    const/high16 v7, 0x10000000

    invoke-virtual {p2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 216
    :cond_2
    const-string/jumbo v7, "REFMARKER"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 217
    .local v6, "refTag":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 218
    invoke-static {v6}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 221
    :cond_3
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/AmazonChooserActivity;->defaultStartActivity(Landroid/content/Intent;)V

    .line 222
    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 144
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/AmazonChooserActivity;->setSeletedResult(Ljava/lang/String;I)V

    .line 145
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity;->finishIfNotFinishing()V

    .line 146
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 58
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 59
    .local v0, "originalIntent":Landroid/content/Intent;
    invoke-static {v0}, Lcom/amazon/mShop/AmazonChooserActivity;->getTargetIntent(Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    .line 60
    .local v1, "targetIntent":Landroid/content/Intent;
    invoke-static {v0}, Lcom/amazon/mShop/AmazonChooserActivity;->getTitleFromIntent(Landroid/content/Intent;)Ljava/lang/CharSequence;

    move-result-object v2

    .line 61
    .local v2, "title":Ljava/lang/CharSequence;
    invoke-direct {p0, v1, v2}, Lcom/amazon/mShop/AmazonChooserActivity;->processTargetIntent(Landroid/content/Intent;Ljava/lang/CharSequence;)V

    .line 62
    return-void
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity;->finishIfNotFinishing()V

    .line 140
    return-void
.end method
