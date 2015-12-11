.class Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;->a:Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 39
    new-instance v1, Landroid/content/Intent;

    const-string v0, "android.intent.action.SEND"

    invoke-direct {v1, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 40
    const-string v0, "text/html"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 41
    const-string v0, "android.intent.extra.EMAIL"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "onlinestore@bestbuy.com"

    aput-object v3, v2, v4

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 43
    :try_start_0
    const-string v0, "android.intent.extra.SUBJECT"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Best Buy Mobile App Feedback ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;->a:Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->a(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;->a:Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->a(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 47
    :goto_0
    const-string v0, "android.intent.extra.TEXT"

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;->a:Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->a(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)Landroid/app/Activity;

    move-result-object v0

    const-string v2, ""

    invoke-static {v1, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 49
    return-void

    .line 44
    :catch_0
    move-exception v0

    .line 45
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method
