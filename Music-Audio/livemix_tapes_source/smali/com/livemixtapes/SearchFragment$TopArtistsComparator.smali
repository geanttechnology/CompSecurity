.class Lcom/livemixtapes/SearchFragment$TopArtistsComparator;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TopArtistsComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Object;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$TopArtistsComparator;->this$0:Lcom/livemixtapes/SearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/SearchFragment;Lcom/livemixtapes/SearchFragment$TopArtistsComparator;)V
    .locals 0

    .prologue
    .line 263
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment$TopArtistsComparator;-><init>(Lcom/livemixtapes/SearchFragment;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Ljava/util/HashMap;

    check-cast p2, Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2}, Lcom/livemixtapes/SearchFragment$TopArtistsComparator;->compare(Ljava/util/HashMap;Ljava/util/HashMap;)I

    move-result v0

    return v0
.end method

.method public compare(Ljava/util/HashMap;Ljava/util/HashMap;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 265
    .local p1, "lhs":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "rhs":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "position"

    invoke-virtual {p1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 266
    .local v0, "lhsPos":I
    const-string v2, "position"

    invoke-virtual {p2, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 267
    .local v1, "rhsPos":I
    sub-int v2, v0, v1

    return v2
.end method
