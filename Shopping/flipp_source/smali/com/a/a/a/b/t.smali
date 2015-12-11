.class final Lcom/a/a/a/b/t;
.super Lcom/a/a/a/l;
.source "SourceFile"


# instance fields
.field final synthetic a:Z

.field final synthetic b:I

.field final synthetic c:I

.field final synthetic d:Lcom/a/a/a/b/j;

.field final synthetic e:Lcom/a/a/a/b/q;


# direct methods
.method varargs constructor <init>(Lcom/a/a/a/b/q;Ljava/lang/String;[Ljava/lang/Object;II)V
    .locals 1

    .prologue
    .line 241
    iput-object p1, p0, Lcom/a/a/a/b/t;->e:Lcom/a/a/a/b/q;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/b/t;->a:Z

    iput p4, p0, Lcom/a/a/a/b/t;->b:I

    iput p5, p0, Lcom/a/a/a/b/t;->c:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/a/b/t;->d:Lcom/a/a/a/b/j;

    invoke-direct {p0, p2, p3}, Lcom/a/a/a/l;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    .line 244
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/t;->e:Lcom/a/a/a/b/q;

    iget-boolean v1, p0, Lcom/a/a/a/b/t;->a:Z

    iget v2, p0, Lcom/a/a/a/b/t;->b:I

    iget-object v3, p0, Lcom/a/a/a/b/t;->d:Lcom/a/a/a/b/j;

    invoke-static {v0, v1, v2, v3}, Lcom/a/a/a/b/q;->a(Lcom/a/a/a/b/q;ZILcom/a/a/a/b/j;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 247
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
