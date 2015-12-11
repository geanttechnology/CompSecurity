.class Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Landroid/content/Context;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Landroid/content/Context;

.field final synthetic c:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Ljava/lang/String;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;->c:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    iput-object p2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;->b:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    .line 212
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.CALL"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "tel:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 213
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;->b:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 214
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 215
    return-void
.end method
