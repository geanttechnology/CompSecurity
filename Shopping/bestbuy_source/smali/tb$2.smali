.class Ltb$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb;->a(Ljava/lang/String;)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ltf;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ltb;


# direct methods
.method constructor <init>(Ltb;)V
    .locals 0

    iput-object p1, p0, Ltb$2;->a:Ltb;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ltf;Ltf;)I
    .locals 4

    iget-wide v0, p1, Ltf;->a:J

    iget-wide v2, p2, Ltf;->a:J

    sub-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Ltf;

    check-cast p2, Ltf;

    invoke-virtual {p0, p1, p2}, Ltb$2;->a(Ltf;Ltf;)I

    move-result v0

    return v0
.end method
