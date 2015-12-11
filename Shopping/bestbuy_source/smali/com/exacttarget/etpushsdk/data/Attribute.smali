.class public Lcom/exacttarget/etpushsdk/data/Attribute;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Comparable;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->b:Ljava/lang/String;

    .line 40
    return-void
.end method


# virtual methods
.method public a(Lcom/exacttarget/etpushsdk/data/Attribute;)I
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 81
    :cond_0
    const/4 v0, 0x0

    .line 84
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    iget-object v1, p1, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 25
    check-cast p1, Lcom/exacttarget/etpushsdk/data/Attribute;

    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/data/Attribute;->a(Lcom/exacttarget/etpushsdk/data/Attribute;)I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    .prologue
    .line 60
    instance-of v0, p1, Lcom/exacttarget/etpushsdk/data/Attribute;

    if-nez v0, :cond_0

    .line 61
    const/4 v0, 0x0

    .line 67
    :goto_0
    return v0

    .line 63
    :cond_0
    check-cast p1, Lcom/exacttarget/etpushsdk/data/Attribute;

    .line 64
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    if-nez v0, :cond_1

    iget-object v0, p1, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 65
    const/4 v0, 0x1

    goto :goto_0

    .line 67
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    iget-object v1, p1, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->b:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 73
    const/4 v0, 0x0

    .line 75
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public setKey(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->a:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Attribute;->b:Ljava/lang/String;

    .line 56
    return-void
.end method
