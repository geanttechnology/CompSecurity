.class Lsp$1;
.super Ljava/lang/Object;

# interfaces
.implements Lss;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsp;-><init>(Lcom/google/android/gms/internal/ay;Labd;Lcom/google/android/gms/internal/gs;Landroid/view/View;Lsr;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lsp;


# direct methods
.method constructor <init>(Lsp;Landroid/view/View;)V
    .locals 0

    iput-object p1, p0, Lsp$1;->b:Lsp;

    iput-object p2, p0, Lsp$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v0, p0, Lsp$1;->b:Lsp;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lsp;->a(Lsp;Z)Z

    iget-object v0, p0, Lsp$1;->b:Lsp;

    iget-object v1, p0, Lsp$1;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Lsp;->a(Landroid/view/View;)V

    iget-object v0, p0, Lsp$1;->b:Lsp;

    invoke-virtual {v0}, Lsp;->a()V

    return-void
.end method
