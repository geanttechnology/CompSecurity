.class Lcom/aio/downloader/activity/MySettingsActivity$1;
.super Landroid/os/Handler;
.source "MySettingsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MySettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    .line 51
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MySettingsActivity$1;)Lcom/aio/downloader/activity/MySettingsActivity;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 10
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 56
    iget v5, p1, Landroid/os/Message;->what:I

    const/16 v6, 0x234

    if-ne v5, v6, :cond_0

    .line 58
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Lcom/aio/downloader/model/GameInfosVersionModel;

    .line 60
    .local v1, "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/model/GameInfosVersionModel;->getUpdatePath()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/aio/downloader/activity/MySettingsActivity;->access$0(Lcom/aio/downloader/activity/MySettingsActivity;Ljava/lang/String;)V

    .line 61
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->newVersionUrl:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/activity/MySettingsActivity;->access$1(Lcom/aio/downloader/activity/MySettingsActivity;)Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 63
    new-instance v2, Lcom/aio/downloader/activity/MySettingsActivity$1$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MySettingsActivity$1$1;-><init>(Lcom/aio/downloader/activity/MySettingsActivity$1;)V

    .line 78
    .local v2, "itemsOnClick":Landroid/view/View$OnClickListener;
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    new-instance v6, Lcom/aio/downloader/dialog/UpdateDialogVerison;

    .line 79
    iget-object v7, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    const v8, 0x7f0c0010

    .line 80
    invoke-direct {v6, v7, v8, v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 78
    invoke-static {v5, v6}, Lcom/aio/downloader/activity/MySettingsActivity;->access$3(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/UpdateDialogVerison;)V

    .line 81
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;
    invoke-static {v5}, Lcom/aio/downloader/activity/MySettingsActivity;->access$2(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/UpdateDialogVerison;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->show()V

    .line 83
    :try_start_0
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;
    invoke-static {v5}, Lcom/aio/downloader/activity/MySettingsActivity;->access$2(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/UpdateDialogVerison;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Update Time: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    invoke-static {v7, v8}, Lcom/aio/downloader/utils/Myutils;->timezhuanhua(J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 84
    const-string v7, " dd, yyyy"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-static {v7, v8, v9}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 83
    invoke-virtual {v5, v6}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->setTvTitle(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 113
    .end local v1    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    .end local v2    # "itemsOnClick":Landroid/view/View$OnClickListener;
    :cond_0
    :goto_0
    return-void

    .line 93
    .restart local v1    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    :cond_1
    new-instance v0, Lcom/aio/downloader/dialog/NoupdareversionDialog;

    .line 94
    iget-object v5, p0, Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    const v6, 0x7f0c000e

    .line 93
    invoke-direct {v0, v5, v6}, Lcom/aio/downloader/dialog/NoupdareversionDialog;-><init>(Landroid/content/Context;I)V

    .line 95
    .local v0, "dialog":Lcom/aio/downloader/dialog/NoupdareversionDialog;
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->setCanceledOnTouchOutside(Z)V

    .line 96
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->show()V

    .line 98
    const v5, 0x7f070140

    invoke-virtual {v0, v5}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 97
    check-cast v4, Landroid/widget/TextView;

    .line 99
    .local v4, "tvversioncontent":Landroid/widget/TextView;
    const-string v5, "Current version: 3.3.9 is the latest version."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    const v5, 0x7f07034d

    invoke-virtual {v0, v5}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 102
    .local v3, "ok":Landroid/widget/Button;
    new-instance v5, Lcom/aio/downloader/activity/MySettingsActivity$1$2;

    invoke-direct {v5, p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity$1$2;-><init>(Lcom/aio/downloader/activity/MySettingsActivity$1;Lcom/aio/downloader/dialog/NoupdareversionDialog;)V

    invoke-virtual {v3, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 86
    .end local v0    # "dialog":Lcom/aio/downloader/dialog/NoupdareversionDialog;
    .end local v3    # "ok":Landroid/widget/Button;
    .end local v4    # "tvversioncontent":Landroid/widget/TextView;
    .restart local v2    # "itemsOnClick":Landroid/view/View$OnClickListener;
    :catch_0
    move-exception v5

    goto :goto_0
.end method
