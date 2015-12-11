.class Lcom/auditude/creativerepackaging/Rule;
.super Ljava/lang/Object;
.source "UrlNormalizingRules.java"


# instance fields
.field public domains:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public find:Ljava/lang/String;

.field public replace:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 1
    .param p1, "find"    # Ljava/lang/String;
    .param p2, "replace"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 253
    .local p3, "domains":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 252
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/creativerepackaging/Rule;->domains:Ljava/util/ArrayList;

    .line 255
    iput-object p1, p0, Lcom/auditude/creativerepackaging/Rule;->find:Ljava/lang/String;

    .line 256
    iput-object p2, p0, Lcom/auditude/creativerepackaging/Rule;->replace:Ljava/lang/String;

    .line 257
    iput-object p3, p0, Lcom/auditude/creativerepackaging/Rule;->domains:Ljava/util/ArrayList;

    .line 258
    return-void
.end method
