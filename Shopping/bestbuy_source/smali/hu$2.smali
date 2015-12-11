.class Lhu$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhu;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhu;


# direct methods
.method constructor <init>(Lhu;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lhu$2;->a:Lhu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lhu$2;->a:Lhu;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lhu;->a(Lhu;I)I

    .line 66
    iget-object v0, p0, Lhu$2;->a:Lhu;

    invoke-static {v0}, Lhu;->b(Lhu;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 67
    return-void
.end method
