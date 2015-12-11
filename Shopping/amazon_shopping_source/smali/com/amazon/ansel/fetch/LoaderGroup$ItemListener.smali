.class Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;
.super Lcom/amazon/ansel/fetch/AbstractLoaderListener;
.source "LoaderGroup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/ansel/fetch/LoaderGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ItemListener"
.end annotation


# instance fields
.field private final loader:Lcom/amazon/ansel/fetch/ResourceLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/amazon/ansel/fetch/LoaderGroup;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderGroup;Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p2, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    iput-object p1, p0, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;->this$0:Lcom/amazon/ansel/fetch/LoaderGroup;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/AbstractLoaderListener;-><init>()V

    .line 98
    iput-object p2, p0, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;->loader:Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 99
    return-void
.end method


# virtual methods
.method public done()V
    .locals 2

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;->this$0:Lcom/amazon/ansel/fetch/LoaderGroup;

    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;->loader:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/LoaderGroup;->loaderDone(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    .line 104
    return-void
.end method
