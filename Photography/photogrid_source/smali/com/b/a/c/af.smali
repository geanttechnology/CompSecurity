.class final Lcom/b/a/c/af;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/FilenameFilter;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/b/a/c/aa;


# direct methods
.method constructor <init>(Lcom/b/a/c/aa;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 810
    iput-object p1, p0, Lcom/b/a/c/af;->b:Lcom/b/a/c/aa;

    iput-object p2, p0, Lcom/b/a/c/af;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 813
    iget-object v0, p0, Lcom/b/a/c/af;->a:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
