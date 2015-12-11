.class final Lcom/a/a/h;
.super Ljava/io/FilterInputStream;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/a/i;


# direct methods
.method constructor <init>(Ljava/io/InputStream;Lcom/a/a/a/i;)V
    .locals 0

    .prologue
    .line 667
    iput-object p2, p0, Lcom/a/a/h;->a:Lcom/a/a/a/i;

    invoke-direct {p0, p1}, Ljava/io/FilterInputStream;-><init>(Ljava/io/InputStream;)V

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 1

    .prologue
    .line 669
    iget-object v0, p0, Lcom/a/a/h;->a:Lcom/a/a/a/i;

    invoke-virtual {v0}, Lcom/a/a/a/i;->close()V

    .line 670
    invoke-super {p0}, Ljava/io/FilterInputStream;->close()V

    .line 671
    return-void
.end method
