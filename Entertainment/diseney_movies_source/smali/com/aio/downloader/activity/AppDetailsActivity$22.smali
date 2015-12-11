.class Lcom/aio/downloader/activity/AppDetailsActivity$22;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1055
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v9, 0x0

    .line 1060
    const/4 v5, 0x0

    .line 1062
    .local v5, "packageInfo_myid":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1063
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    .line 1062
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 1068
    :goto_0
    new-instance v1, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v1, v6}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 1070
    .local v1, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_1
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$80(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1075
    :goto_1
    if-nez v5, :cond_1

    .line 1076
    new-instance v0, Landroid/content/Intent;

    const-string v6, "android.intent.action.VIEW"

    invoke-direct {v0, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1077
    .local v0, "aa":Landroid/content/Intent;
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "file://"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->stringExtra:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$81(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1078
    const-string v7, "application/vnd.android.package-archive"

    .line 1077
    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 1079
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 1094
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_2
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I
    invoke-static {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 1095
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;
    invoke-static {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$30(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->myVer:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$82(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    if-eqz v5, :cond_2

    .line 1097
    :try_start_2
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1098
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    .line 1100
    .local v4, "intentopen_this_app":Landroid/content/Intent;
    const/high16 v6, 0x10000000

    invoke-virtual {v4, v6}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1101
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 1116
    .end local v4    # "intentopen_this_app":Landroid/content/Intent;
    :cond_0
    :goto_3
    return-void

    .line 1064
    .end local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v3

    .line 1065
    .local v3, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v5, 0x0

    .line 1066
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 1071
    .end local v3    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_1
    move-exception v2

    .line 1073
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 1082
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    :try_start_3
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1083
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    .line 1085
    .restart local v4    # "intentopen_this_app":Landroid/content/Intent;
    const/high16 v6, 0x10000000

    invoke-virtual {v4, v6}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1086
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_2

    .line 1087
    .end local v4    # "intentopen_this_app":Landroid/content/Intent;
    :catch_2
    move-exception v2

    .line 1089
    .local v2, "e":Ljava/lang/Exception;
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1090
    const-string v7, "This program is protected"

    .line 1089
    invoke-static {v6, v7, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v6

    .line 1091
    invoke-virtual {v6}, Landroid/widget/Toast;->show()V

    goto :goto_2

    .line 1102
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v2

    .line 1104
    .restart local v2    # "e":Ljava/lang/Exception;
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1105
    const-string v7, "This program is protected"

    .line 1104
    invoke-static {v6, v7, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v6

    .line 1106
    invoke-virtual {v6}, Landroid/widget/Toast;->show()V

    goto :goto_3

    .line 1109
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_2
    new-instance v0, Landroid/content/Intent;

    const-string v6, "android.intent.action.VIEW"

    invoke-direct {v0, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1110
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "file://"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->stringExtra:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$81(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1111
    const-string v7, "application/vnd.android.package-archive"

    .line 1110
    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 1112
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$22;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v6, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_3
.end method
