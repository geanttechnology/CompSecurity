.class public interface abstract Lcom/adobe/mediacore/logging/Logger;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/logging/Logger$Verbosity;
    }
.end annotation


# virtual methods
.method public abstract clear()V
.end method

.method public abstract d(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract e(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
.end method

.method public abstract getEntries()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/logging/LogEntry;",
            ">;"
        }
    .end annotation
.end method

.method public abstract i(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract setCapacity(I)V
.end method

.method public abstract setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
.end method

.method public abstract w(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
.end method
