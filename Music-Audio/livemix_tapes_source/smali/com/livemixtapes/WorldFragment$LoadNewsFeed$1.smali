.class Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;
.super Ljava/lang/Object;
.source "WorldFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->onPostExecute(Lorg/json/JSONObject;)V
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
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/WorldFragment$LoadNewsFeed;


# direct methods
.method constructor <init>(Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;->this$1:Lcom/livemixtapes/WorldFragment$LoadNewsFeed;

    .line 213
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Ljava/util/HashMap;

    check-cast p2, Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;->compare(Ljava/util/HashMap;Ljava/util/HashMap;)I

    move-result v0

    return v0
.end method

.method public compare(Ljava/util/HashMap;Ljava/util/HashMap;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 218
    .local p1, "lhs":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "rhs":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;->this$1:Lcom/livemixtapes/WorldFragment$LoadNewsFeed;

    # getter for: Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;
    invoke-static {v2}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->access$3(Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)Lcom/livemixtapes/WorldFragment;

    move-result-object v3

    .line 219
    const-string v2, "timestamp"

    invoke-virtual {p1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 218
    invoke-virtual {v3, v2}, Lcom/livemixtapes/WorldFragment;->convertUtcToDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 220
    .local v0, "lhsDate":Ljava/util/Date;
    iget-object v2, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;->this$1:Lcom/livemixtapes/WorldFragment$LoadNewsFeed;

    # getter for: Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;
    invoke-static {v2}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->access$3(Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)Lcom/livemixtapes/WorldFragment;

    move-result-object v3

    .line 221
    const-string v2, "timestamp"

    invoke-virtual {p2, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 220
    invoke-virtual {v3, v2}, Lcom/livemixtapes/WorldFragment;->convertUtcToDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 222
    .local v1, "rhsDate":Ljava/util/Date;
    if-eqz v0, :cond_0

    if-nez v1, :cond_1

    .line 223
    :cond_0
    const/4 v2, 0x0

    .line 224
    :goto_0
    return v2

    :cond_1
    invoke-virtual {v1, v0}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v2

    goto :goto_0
.end method
