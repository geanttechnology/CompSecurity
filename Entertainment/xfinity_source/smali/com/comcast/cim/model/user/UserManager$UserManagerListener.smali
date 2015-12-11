.class public interface abstract Lcom/comcast/cim/model/user/UserManager$UserManagerListener;
.super Ljava/lang/Object;
.source "UserManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/model/user/UserManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "UserManagerListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/model/user/User;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation
.end method

.method public abstract onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation
.end method

.method public abstract onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation
.end method

.method public abstract onUserLoggedOut()V
.end method
