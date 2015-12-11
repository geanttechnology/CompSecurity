.class public Lcom/amazon/identity/auth/device/storage/DatabaseValue;
.super Ljava/lang/Object;
.source "DatabaseValue.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/utils/PublicCloneable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
        "<",
        "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field private final mDateTime:Ljava/util/Date;

.field private mIsDeleted:Z

.field private mIsDirty:Z

.field private final mValue:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V
    .locals 1
    .param p2, "dateTime"    # Ljava/util/Date;
    .param p3, "isDirty"    # Z
    .param p4, "isDeleted"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/util/Date;",
            "ZZ)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const-string/jumbo v0, "dateTime"

    invoke-static {p2, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 25
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    .line 26
    invoke-virtual {p2}, Ljava/util/Date;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Date;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    .line 27
    iput-boolean p3, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    .line 28
    iput-boolean p4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    .line 29
    return-void
.end method


# virtual methods
.method public cloneObject()Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 139
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    :try_start_0
    new-instance v2, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->typeSafeClone(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Date;

    iget-boolean v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    iget-boolean v5, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    invoke-direct {v2, v3, v1, v4, v5}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;-><init>(Ljava/lang/Object;Ljava/util/Date;ZZ)V
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 144
    :catch_0
    move-exception v0

    .line 146
    .local v0, "e":Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public bridge synthetic cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;
    .locals 1

    .prologue
    .line 14
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->cloneObject()Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 108
    if-ne p0, p1, :cond_1

    .line 119
    :cond_0
    :goto_0
    return v1

    .line 112
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 114
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 117
    check-cast v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;

    .line 119
    .local v0, "otherObj":Lcom/amazon/identity/auth/device/storage/DatabaseValue;
    iget-boolean v3, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    iget-boolean v4, v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    if-ne v3, v4, :cond_4

    iget-boolean v3, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    iget-boolean v4, v0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getDateTime()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method getDateTime()Ljava/util/Date;
    .locals 1

    .prologue
    .line 38
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Date;

    return-object v0
.end method

.method getValue()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    return-object v0
.end method

.method public hashCode()I
    .locals 6

    .prologue
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    const/16 v4, 0x4d5

    const/16 v3, 0x4cf

    const/4 v2, 0x0

    .line 94
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 99
    .local v0, "result":I
    mul-int/lit8 v5, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    if-eqz v1, :cond_1

    move v1, v3

    :goto_1
    add-int v0, v5, v1

    .line 100
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v5, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    if-eqz v5, :cond_2

    :goto_2
    add-int v0, v1, v3

    .line 101
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    if-nez v3, :cond_3

    :goto_3
    add-int/2addr v1, v2

    .line 102
    return v1

    .line 94
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    goto :goto_0

    .restart local v0    # "result":I
    :cond_1
    move v1, v4

    .line 99
    goto :goto_1

    :cond_2
    move v3, v4

    .line 100
    goto :goto_2

    .line 101
    :cond_3
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_3
.end method

.method isAfter(Ljava/util/Date;)Z
    .locals 1
    .param p1, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 73
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    if-nez p1, :cond_0

    .line 75
    const/4 v0, 0x1

    .line 78
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v0

    goto :goto_0
.end method

.method isDeleted()Z
    .locals 1

    .prologue
    .line 48
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    return v0
.end method

.method isDirty()Z
    .locals 1

    .prologue
    .line 43
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    return v0
.end method

.method isLaterThan(Lcom/amazon/identity/auth/device/storage/DatabaseValue;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 83
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    .local p1, "otherValue":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    if-nez p1, :cond_0

    .line 85
    const/4 v0, 0x1

    .line 88
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    iget-object v1, p1, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v0, v1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v0

    goto :goto_0
.end method

.method setNotDirtyIfHasCurrentTimeStamp(Ljava/util/Date;)V
    .locals 1
    .param p1, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 59
    :goto_0
    return-void

    .line 58
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    goto :goto_0
.end method

.method setNotDirtyIfIsBeforeOrEqualToTimestamp(Ljava/util/Date;)V
    .locals 1
    .param p1, "dateTime"    # Ljava/util/Date;

    .prologue
    .line 63
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    :goto_0
    return-void

    .line 68
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 126
    .local p0, "this":Lcom/amazon/identity/auth/device/storage/DatabaseValue;, "Lcom/amazon/identity/auth/device/storage/DatabaseValue<TT;>;"
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v2, "Value: %s, TimeStamp: %d, Deleted: %s, Dirty: %s"

    const/4 v0, 0x4

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mValue:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v3, v4

    const/4 v0, 0x1

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mDateTime:Ljava/util/Date;

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x2

    iget-boolean v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDeleted:Z

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x3

    iget-boolean v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseValue;->mIsDirty:Z

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    invoke-static {v1, v2, v3}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string/jumbo v0, "None"

    goto :goto_0
.end method
