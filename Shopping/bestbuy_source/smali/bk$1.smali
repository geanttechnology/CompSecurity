.class final Lbk$1;
.super Lbl;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lbk;
.end annotation


# instance fields
.field private synthetic b:Ljava/net/URLConnection;


# direct methods
.method constructor <init>(Lbk;Ljava/net/URLConnection;)V
    .locals 1

    .prologue
    .line 288
    iput-object p2, p0, Lbk$1;->b:Ljava/net/URLConnection;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lbl;-><init>(Lbk;B)V

    return-void
.end method


# virtual methods
.method final a()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lbk$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method
