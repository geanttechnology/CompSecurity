.class Lis$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lis;->c()V
.end annotation


# instance fields
.field final synthetic a:Lis;


# direct methods
.method constructor <init>(Lis;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lis$2;->a:Lis;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lis$2;->a:Lis;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lis;->a(Lis;I)I

    .line 47
    iget-object v0, p0, Lis$2;->a:Lis;

    invoke-static {v0}, Lis;->d(Lis;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 48
    return-void
.end method
