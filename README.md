# JavaPublisher
Java Messaging Service- Spring Mvc, Spring Boor, ActiveMQ

# Activemq broker credential 

activemq file

		<plugins>
			<!-- Configure authentication: Username, passwords and groups -->
			<simpleAuthenticationPlugin>
				<users>
					<authenticationUser username="admin" password="admin" groups="admins"/>
				</users>
			</simpleAuthenticationPlugin>
			
			<!-- Lets configure a destination based authorization mechanism -->
			<authorizationPlugin>
				<map>
					<authorizationMap>
						<authorizationEntries>
							<authorizationEntry queue=">" read="admins" write="admins" admin="admins" />
							<authorizationEntry topic=">" read="admins" write="admins" admin="admins" />
						</authorizationEntries>
					</authorizationMap>
				</map>
			</authorizationPlugin>
		</plugins>

credential.properties

Defines credentials that will be used by components (like web console) to access the broker

activemq.username=admin
activemq.password=admin
guest.password=password