.class final Lw;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;


# instance fields
.field private final a:Ljava/lang/Long;

.field private final b:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/Long;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lw;->a:Ljava/lang/Long;

    .line 24
    iput-object p2, p0, Lw;->b:Ljava/lang/String;

    .line 25
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Long;Ljava/lang/String;B)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lw;-><init>(Ljava/lang/Long;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lw;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lw;->b:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public final bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 2

    .prologue
    .line 18
    check-cast p1, Lw;

    iget-object v0, p0, Lw;->a:Ljava/lang/Long;

    iget-object v1, p1, Lw;->a:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    return v0
.end method
