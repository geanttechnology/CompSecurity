.class public Lcom/amazon/android/webkit/AmazonWebTimings;
.super Ljava/lang/Object;
.source "AmazonWebTimings.java"

# interfaces
.implements Ljava/lang/Cloneable;


# virtual methods
.method public clone()Lcom/amazon/android/webkit/AmazonWebTimings;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 159
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/webkit/AmazonWebTimings;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 11
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebTimings;->clone()Lcom/amazon/android/webkit/AmazonWebTimings;

    move-result-object v0

    return-object v0
.end method
