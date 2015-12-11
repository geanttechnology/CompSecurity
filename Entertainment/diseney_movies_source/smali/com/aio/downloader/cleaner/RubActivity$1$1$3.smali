.class Lcom/aio/downloader/cleaner/RubActivity$1$1$3;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$1$1;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

.field private final synthetic val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;Lcom/aio/downloader/dialog/CleanerDialog1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    iput-object p2, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;

    .line 208
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 211
    const-string v3, "http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click"

    invoke-static {v3}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 212
    const/4 v2, 0x0

    .line 214
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->access$2(Lcom/aio/downloader/cleaner/RubActivity$1$1;)Lcom/aio/downloader/cleaner/RubActivity$1;

    move-result-object v3

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v3

    .line 215
    invoke-virtual {v3}, Lcom/aio/downloader/cleaner/RubActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 217
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    .line 216
    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 221
    :goto_0
    if-nez v2, :cond_0

    .line 222
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->access$2(Lcom/aio/downloader/cleaner/RubActivity$1$1;)Lcom/aio/downloader/cleaner/RubActivity$1;

    move-result-object v3

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v3

    # invokes: Lcom/aio/downloader/cleaner/RubActivity;->installApk()V
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity;->access$15(Lcom/aio/downloader/cleaner/RubActivity;)V

    .line 229
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;

    invoke-virtual {v3}, Lcom/aio/downloader/dialog/CleanerDialog1;->dismiss()V

    .line 295
    return-void

    .line 218
    :catch_0
    move-exception v0

    .line 219
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 224
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->access$2(Lcom/aio/downloader/cleaner/RubActivity$1$1;)Lcom/aio/downloader/cleaner/RubActivity$1;

    move-result-object v3

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/cleaner/RubActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 226
    const-string v4, "com.evzapp.cleanmaster"

    .line 225
    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 227
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->access$2(Lcom/aio/downloader/cleaner/RubActivity$1$1;)Lcom/aio/downloader/cleaner/RubActivity$1;

    move-result-object v3

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method
