.class Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2$1;
.super Ljava/lang/Object;
.source "HistorySpeechRecognizer.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2;->execute()Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2$1;->this$1:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/bookmarks/Bookmark;)I
    .locals 2
    .param p1, "lhs"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p2, "rhs"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    .line 118
    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 115
    check-cast p1, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    check-cast p2, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$2$1;->compare(Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/bookmarks/Bookmark;)I

    move-result v0

    return v0
.end method
