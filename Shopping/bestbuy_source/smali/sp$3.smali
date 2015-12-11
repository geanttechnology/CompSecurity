.class Lsp$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsp;-><init>(Lcom/google/android/gms/internal/ay;Labd;Lcom/google/android/gms/internal/gs;Landroid/view/View;Lsr;)V
.end annotation


# instance fields
.field final synthetic a:Lsp;


# direct methods
.method constructor <init>(Lsp;)V
    .locals 0

    iput-object p1, p0, Lsp$3;->a:Lsp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lsp$3;->a:Lsp;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lsp;->b(Z)V

    return-void
.end method
