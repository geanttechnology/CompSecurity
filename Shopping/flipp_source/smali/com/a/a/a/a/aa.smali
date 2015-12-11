.class final Lcom/a/a/a/a/aa;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/a/c;


# instance fields
.field final synthetic a:Lcom/a/a/a/a/z;


# direct methods
.method constructor <init>(Lcom/a/a/a/a/z;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 126
    const-string v0, "no-cache"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 127
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {v0}, Lcom/a/a/a/a/z;->b(Lcom/a/a/a/a/z;)Z

    .line 139
    :cond_0
    :goto_0
    return-void

    .line 128
    :cond_1
    const-string v0, "no-store"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 129
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {v0}, Lcom/a/a/a/a/z;->c(Lcom/a/a/a/a/z;)Z

    goto :goto_0

    .line 130
    :cond_2
    const-string v0, "max-age"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 131
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {p2}, Lcom/a/a/a/a/b;->a(Ljava/lang/String;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/a/a/a/a/z;->a(Lcom/a/a/a/a/z;I)I

    goto :goto_0

    .line 132
    :cond_3
    const-string v0, "s-maxage"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 133
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {p2}, Lcom/a/a/a/a/b;->a(Ljava/lang/String;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/a/a/a/a/z;->b(Lcom/a/a/a/a/z;I)I

    goto :goto_0

    .line 134
    :cond_4
    const-string v0, "public"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 135
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {v0}, Lcom/a/a/a/a/z;->d(Lcom/a/a/a/a/z;)Z

    goto :goto_0

    .line 136
    :cond_5
    const-string v0, "must-revalidate"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/a/a/a/a/aa;->a:Lcom/a/a/a/a/z;

    invoke-static {v0}, Lcom/a/a/a/a/z;->e(Lcom/a/a/a/a/z;)Z

    goto :goto_0
.end method
