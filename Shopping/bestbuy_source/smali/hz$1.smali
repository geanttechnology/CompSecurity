.class Lhz$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhz;->b()V
.end annotation


# instance fields
.field final synthetic a:Lhz;


# direct methods
.method constructor <init>(Lhz;)V
    .locals 0

    .prologue
    .line 217
    iput-object p1, p0, Lhz$1;->a:Lhz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 220
    iget-object v0, p0, Lhz$1;->a:Lhz;

    invoke-static {v0}, Lhz;->a(Lhz;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 221
    return-void
.end method
