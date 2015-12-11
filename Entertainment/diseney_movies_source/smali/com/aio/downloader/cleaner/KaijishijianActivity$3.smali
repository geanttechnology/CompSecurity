.class Lcom/aio/downloader/cleaner/KaijishijianActivity$3;
.super Ljava/lang/Object;
.source "KaijishijianActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/KaijishijianActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 76
    const/4 v2, 0x0

    .line 78
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 79
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 83
    :goto_0
    if-nez v2, :cond_0

    .line 84
    iget-object v3, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    # invokes: Lcom/aio/downloader/cleaner/KaijishijianActivity;->installApk()V
    invoke-static {v3}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->access$0(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V

    .line 90
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->finish()V

    .line 91
    return-void

    .line 80
    :catch_0
    move-exception v0

    .line 81
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 86
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 87
    const-string v4, "com.evzapp.cleanmaster"

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 88
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    invoke-virtual {v3, v1}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method
