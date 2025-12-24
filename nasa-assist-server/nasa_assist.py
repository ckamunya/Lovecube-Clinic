import time
import os
from datetime import datetime

class NasaSecurityAgent:
    def __init__(self):
        print("NASA ASSIST: RSE Agent Online via Python")
        self.safe_zone_active = True

    def analyze_logs(self, log_entry):
        # Rule 1: Mass Export Detection
        if "EXPORT_ALL" in log_entry:
            print("!!! CRITICAL: Mass Data Export Detected !!!")
            self.trigger_lockdown()

        # Rule 2: After Hours Check
        current_hour = datetime.now().hour
        if current_hour < 6 or current_hour > 22:
            print(f"WARNING: After hours access detected at {current_hour}:00")

    def trigger_lockdown(self):
        print("LOCKDOWN INITIATED: Revoking certificates...")
        # Code to kill Citrix tunnel would go here

if __name__ == "__main__":
    agent = NasaSecurityAgent()
    # Simulating a log stream
    while True:
        print("Listening for secure tunnel logs...")
        time.sleep(5)