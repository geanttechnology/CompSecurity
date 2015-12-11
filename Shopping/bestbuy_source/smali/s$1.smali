.class final Ls$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ls;
.end annotation


# instance fields
.field private synthetic a:Ls;


# direct methods
.method constructor <init>(Ls;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Ls$1;->a:Ls;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Ls$1;->a:Ls;

    invoke-static {v0}, Ls;->a(Ls;)I

    .line 56
    return-void
.end method
