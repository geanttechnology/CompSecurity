.class final Lnm$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnm;->a(Landroid/content/Context;Lnn;)V
.end annotation


# instance fields
.field final synthetic a:Lnn;


# direct methods
.method constructor <init>(Lnn;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lnm$1;->a:Lnn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    sput-boolean v0, Lnm;->d:Z

    .line 27
    iget-object v0, p0, Lnm$1;->a:Lnn;

    invoke-interface {v0}, Lnn;->a()V

    .line 28
    return-void
.end method
