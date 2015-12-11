.class Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Landroid/content/Context;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)V
    .locals 0

    .prologue
    .line 217
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$5;->a:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 221
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 222
    return-void
.end method
