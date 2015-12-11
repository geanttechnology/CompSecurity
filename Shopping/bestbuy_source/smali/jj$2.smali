.class Ljj$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljj;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljj;


# direct methods
.method constructor <init>(Ljj;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Ljj$2;->a:Ljj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 88
    const/4 v0, 0x0

    invoke-static {v0}, Ljj;->a(I)I

    .line 89
    iget-object v0, p0, Ljj$2;->a:Ljj;

    invoke-static {v0}, Ljj;->a(Ljj;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 90
    return-void
.end method
