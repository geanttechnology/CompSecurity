.class Lcom/poshmark/utils/PMTrie$TrieNode;
.super Ljava/lang/Object;
.source "PMTrie.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/PMTrie;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TrieNode"
.end annotation


# instance fields
.field label:Ljava/lang/String;

.field list:[Lcom/poshmark/utils/PMTrie$TrieNode;

.field final synthetic this$0:Lcom/poshmark/utils/PMTrie;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMTrie;)V
    .locals 1

    .prologue
    .line 12
    iput-object p1, p0, Lcom/poshmark/utils/PMTrie$TrieNode;->this$0:Lcom/poshmark/utils/PMTrie;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/16 v0, 0x1a

    new-array v0, v0, [Lcom/poshmark/utils/PMTrie$TrieNode;

    iput-object v0, p0, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    return-void
.end method
