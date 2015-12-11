.class Lsp$6;
.super Ljava/lang/Object;

# interfaces
.implements Lvd;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsp;->b(Lsr;)V
.end annotation


# instance fields
.field final synthetic a:Lsp;


# direct methods
.method constructor <init>(Lsp;)V
    .locals 0

    iput-object p1, p0, Lsp$6;->a:Lsp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/internal/gu;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/gu;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lsp$6;->a:Lsp;

    invoke-virtual {v0, p2}, Lsp;->a(Ljava/util/Map;)Z

    move-result v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Received request to untrack: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lsp$6;->a:Lsp;

    invoke-static {v1}, Lsp;->a(Lsp;)Lsn;

    move-result-object v1

    invoke-virtual {v1}, Lsn;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lsp$6;->a:Lsp;

    invoke-virtual {v0}, Lsp;->c()V

    goto :goto_0
.end method
