.class Ljv$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljv;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljv;


# direct methods
.method constructor <init>(Ljv;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Ljv$1;->a:Ljv;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Ljv$1;->a:Ljv;

    invoke-virtual {v0}, Ljv;->d()V

    .line 81
    return-void
.end method
